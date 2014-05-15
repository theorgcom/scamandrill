package com.joypeg.scamandrill.client

import scala.concurrent.Future
import spray.httpx.marshalling._
import spray.client.pipelining._
import com.joypeg.scamandrill.models._

object MandrillAsyncClient extends MandrillClient with ScamandrillSendReceive {

  import spray.httpx.SprayJsonSupport._
  import com.joypeg.scamandrill.models.MandrillJsonProtocol._

  /////////////////////////////////////////////////////////////
  //USER calls https://mandrillapp.com/api/docs/users.JSON.html
  /////////////////////////////////////////////////////////////

  override def ping(ping: MPing): Future[MPingResponse] = {
    executeQuery[MPingResponse](Endpoints.ping.endpoint, marshal(ping))(unmarshal[String].andThen(MPingResponse))
  }

  override def ping2(ping: MPing): Future[MPingResponse] = {
    executeQuery[MPingResponse](Endpoints.ping2.endpoint, marshal(ping))(unmarshal[MPingResponse])
  }

  override def senders(ping: MPing): Future[List[MSenderDataResponse]] = {
    executeQuery[List[MSenderDataResponse]](Endpoints.senders.endpoint, marshal(ping))(unmarshal[List[MSenderDataResponse]])
  }

  override def info(ping: MPing): Future[MInfoResponse] = {
    executeQuery[MInfoResponse](Endpoints.info.endpoint, marshal(ping))(unmarshal[MInfoResponse])
  }

  ////////////////////////////////////////////////////////////////////
  //MESSAGES calls https://mandrillapp.com/api/docs/messages.JSON.html
  ////////////////////////////////////////////////////////////////////

  override def send(msg: MSendMessage): Future[List[MSendResponse]] = {
    executeQuery[List[MSendResponse]](Endpoints.send.endpoint, marshal(msg))(unmarshal[List[MSendResponse]])
  }

  override def sendTemplate(msg: MSendTemplateMessage): Future[List[MSendResponse]] = {
    executeQuery[List[MSendResponse]](Endpoints.sendTemplate.endpoint, marshal(msg))(unmarshal[List[MSendResponse]])
  }

  override def search(q: MSearch): Future[List[MSearchResponse]] = {
    executeQuery[List[MSearchResponse]](Endpoints.search.endpoint, marshal(q))(unmarshal[List[MSearchResponse]])
  }

  override def searchTimeSeries(q: MSearchTimeSeries): Future[List[MTimeSeriesResponse]] = {
    executeQuery[List[MTimeSeriesResponse]](Endpoints.searchTimeS.endpoint, marshal(q))(unmarshal[List[MTimeSeriesResponse]])
  }

  override def messageInfo(q: MMessageInfo): Future[MMessageInfoResponse] = {
    executeQuery[MMessageInfoResponse](Endpoints.msginfo.endpoint, marshal(q))(unmarshal[MMessageInfoResponse])
  }

  override def content(q: MMessageInfo): Future[MContentResponse] = {
    executeQuery[MContentResponse](Endpoints.content.endpoint, marshal(q))(unmarshal[MContentResponse])
  }

  override def parse(raw: MParse): Future[MParseResponse] = {
    executeQuery[MParseResponse](Endpoints.parse.endpoint, marshal(raw))(unmarshal[MParseResponse])
  }

  override def sendRaw(raw: MSendRaw): Future[List[MSendResponse]] = {
    executeQuery[List[MSendResponse]](Endpoints.sendraw.endpoint, marshal(raw))(unmarshal[List[MSendResponse]])
  }

  override def listSchedule(sc: MListSchedule): Future[List[MScheduleResponse]] = {
    executeQuery[List[MScheduleResponse]](Endpoints.listSchedule.endpoint, marshal(sc))(unmarshal[List[MScheduleResponse]])
  }

  override def cancelSchedule(sc: MCancelSchedule): Future[MScheduleResponse] = {
    executeQuery[MScheduleResponse](Endpoints.cancelSchedule.endpoint, marshal(sc))(unmarshal[MScheduleResponse])
  }

  override def reSchedule(sc: MReSchedule): Future[MScheduleResponse] = {
    executeQuery[MScheduleResponse](Endpoints.reschedule.endpoint, marshal(sc))(unmarshal[MScheduleResponse])
  }

  ////////////////////////////////////////////////////////////
  //TAGS calls https://mandrillapp.com/api/docs/tags.JSON.html
  ////////////////////////////////////////////////////////////

  override def tagList(tag: MTag): Future[List[MTagResponse]] = {
    executeQuery[List[MTagResponse]](Endpoints.taglist.endpoint, marshal(tag))(unmarshal[List[MTagResponse]])
  }

  override def tagDelete(tag: MTagRequest): Future[MTagResponse] = {
    executeQuery[MTagResponse](Endpoints.tagdelete.endpoint, marshal(tag))(unmarshal[MTagResponse])
  }

  override def tagInfo(tag: MTagRequest): Future[MTagInfoResponse] = {
    executeQuery[MTagInfoResponse](Endpoints.taginfo.endpoint, marshal(tag))(unmarshal[MTagInfoResponse])
  }

  override def tagTimeSeries(tag: MTagRequest): Future[List[MTimeSeriesResponse]] = {
    executeQuery[List[MTimeSeriesResponse]](Endpoints.tagtimeseries.endpoint, marshal(tag))(unmarshal[List[MTimeSeriesResponse]])
  }

  override def tagAllTimeSeries(tag: MTag): Future[List[MTimeSeriesResponse]] = {
    executeQuery[List[MTimeSeriesResponse]](Endpoints.tagalltime.endpoint, marshal(tag))(unmarshal[List[MTimeSeriesResponse]])
  }

  override def shutdownSystem(): Unit = shutdown()

}
