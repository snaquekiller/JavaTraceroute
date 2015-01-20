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

import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Represents a randomly generated trace.
 * 
 * @author Frédéric Fauberteau
 *
 */
class FakeTrace {
  
  private final String host;
  
  private final InetAddress address;
  
  private final ArrayList<Hop> hops = new ArrayList<>();
  
  /**
   * This constructor just gets the FakeTrace ready.
   * @param address the destination address of the traceroute
   */
  FakeTrace(String host, InetAddress address) {
    this.host = host;
    this.address = address;
  }
  
  void addHop(Hop hop) {
    hops.add(hop);
  }
  
  String getHeader() {
    return "traceroute to " + host + " (" + address.getHostAddress() + "), 30 hops max, 60 byte packets";
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getHeader()).append('\n');
    for (int i = 0; i < hops.size(); i++) {
      if (i + 1 < 10) {
        sb.append(' ');
      }
      sb.append(i + 1).append("  ").append(hops.get(i)).append('\n');
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }

}
