/* Copyright (c) 2015, Frédéric Fauberteau
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package tracerouteh.trace;

import tracerouteh.trace.AddressTry;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * A factory to randomly generate hop.
 * 
 * @author Frédéric Fauberteau
 *
 */
class HopFactory {
  
  private final Random rand = new Random();
  
	/**
	 * Generates a hop randomly. Each tries can fail or success.
	 * 
	 * @return a hop randomly generated
	 * @throws UnknownHostException
	 */
  Hop getRandomHop() throws UnknownHostException {
    Try[] tries = new Try[3];
    tries[0] = getFailedOrAddressTry();
    if (tries[0] instanceof AddressTry) {
      tries[1] = getAnyTry();
    } else {
      tries[1] = getFailedOrAddressTry();
    }
    if (tries[1] instanceof AddressTry) {
      tries[2] = getAnyTry();
    } else {
      tries[2] = getFailedOrAddressTry();
    }
    return new Hop(tries[0], tries[1], tries[2]);
  }
  
  	/**
	 * Generates a hop randomly by using an address which must be reached (i.e
	 * the final destination hop).
	 * 
	 * @param address
	 *            the address which can be in the hop
	 * @return a hop randomly generated
	 */
  Hop getParameterizedHop(InetAddress address) {
    Try[] tries = new Try[3];
    int pos = rand.nextInt(3);
    if (pos == 0) {
      tries[0] = new AddressTry(address);
    } else {
      tries[0] = new FailedTry();
    }
    if (pos == 1) {
      tries[1] = new AddressTry(address);
    } else {
      if (tries[0] instanceof AddressTry) {
        tries[1] = getFailedOrNoAddressTry();
      } else {
        tries[1] = new FailedTry();
      }
    }
    if (pos == 2) {
      tries[2] = new AddressTry(address);
    } else {
      if (tries[1] instanceof AddressTry) {
        tries[2] = getFailedOrNoAddressTry();
      } else {
        tries[2] = new FailedTry();
      }
    }
    return new Hop(tries[0], tries[1], tries[2]);
  }
  
  private Try getFailedOrAddressTry() throws UnknownHostException {
    int r = rand.nextInt(10);
    if (r < 2) {
      return new FailedTry();
    } else {
      return new AddressTry(getRandomAddress());
    }
  }
  
  private Try getAnyTry() throws UnknownHostException {
    int r = rand.nextInt(10);
    if (r < 2) {
      return new FailedTry();
    } else if (r < 5) {
      return new AddressTry(getRandomAddress());
    } else {
      return new NoAddressTry();
    }
  }
  
  private Try getFailedOrNoAddressTry() {
    int r = rand.nextInt(10);
    if (r < 2) {
      return new FailedTry();
    } else {
      return new NoAddressTry();
    }
  }
  
  private InetAddress getRandomAddress() throws UnknownHostException {
    byte[] bytes = new byte[4];
    bytes[0] = (byte) (rand.nextInt(255) + 1);
    bytes[1] = (byte) rand.nextInt(256);
    bytes[2] = (byte) rand.nextInt(256);
    bytes[3] = (byte) (rand.nextInt(254) + 1);
    return InetAddress.getByAddress(bytes);
  }

}
