import clients.*
import zio.*
import zio.http.{Client, ZClient}

object Main extends ZIOAppDefault:
  def run: URIO[Any, ExitCode] =
    val program = for 
      client <- ZIO.service[IPServiceClient]
      ipResponse <- client.getIp
      _ <- Console.printLine(s"Your IP is: ${ipResponse.ip}")
    yield ()

    program.provideLayer(Client.default >>> IPServiceClient.layer).exitCode
