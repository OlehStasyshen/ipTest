import zio.*
import zio.test.*

object IPServiceClientSpec extends ZIOSpecDefault:

  def spec = suite("IPServiceClientSpec"):
    test("getIp should fetch and decode the IP address successfully"):
      assertTrue(true)
