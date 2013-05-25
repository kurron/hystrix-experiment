/*******************************************************************************
 * Copyright year Ronald D. Kurr kurr@kurron.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package org.kurron.hystrix

import spock.lang.Specification

import java.util.concurrent.Future

/**
 * Learning test of the HystrixCommand object.
 */
class HystrixCommandUnitTest  extends Specification {

    def 'execute a synchronous command'() {
        given:
        CommandHelloWorld sut = new CommandHelloWorld( 'Logan' )

        when:
        String results = sut.execute()

        then:
        println results
        assert results.contains( 'Logan' )
    }

    def 'execute an asynchronous command'() {
        given:
        CommandHelloWorld sut = new CommandHelloWorld( 'Devan' )

        when:
        Future<String> future = sut.queue()
        String results = future.get()
        then:
        println results
        assert results.contains( 'Devan' )
    }

}
