package sample.camel

/**
 * Created by akondiuk on 11/06/15.
 */
package sample.camel

import akka.actor.{Props, ActorSystem}
import akka.camel.{ CamelMessage, Consumer }
import akka.camel.Consumer

object FilePoller {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("my-file-poller")
    system.actorOf(Props[MyFilePoller])
  }

  class MyFilePoller extends Consumer {
    def endpointUri = "file:data/input/actor"

    def receive = {
      case msg: CamelMessage => println("received %s" format msg.bodyAs[String])
    }
  }

}

