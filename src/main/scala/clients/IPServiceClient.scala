package clients

import zio.*
import zio.http.*
import zio.json.*
import zio.json.*


class IPServiceClient(client: Client):
  private val IP_API_URI = "https://api.ipify.org/?format=json"
  private val IP_REQUEST = Request.get(IP_API_URI)

  def getIp: Task[IpServiceResponse] = 
    ZIO.scoped: 
      client.request(IP_REQUEST).flatMap:
        response =>
          response.body.asString.flatMap(str => ZIO.fromEither(str.fromJson[IpServiceResponse]).mapError(e => throw RuntimeException(e)))

object IPServiceClient:
  val layer: ZLayer[Client, Throwable, IPServiceClient] = ZLayer.fromFunction(IPServiceClient(_))

case class IpServiceResponse(ip: String)

object IpServiceResponse:
  implicit val decoder: JsonDecoder[IpServiceResponse] = DeriveJsonDecoder.gen[IpServiceResponse]
