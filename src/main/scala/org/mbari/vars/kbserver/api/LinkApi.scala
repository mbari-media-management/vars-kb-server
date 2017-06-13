package org.mbari.vars.kbserver.api

import org.mbari.vars.kbserver.dao.DAOFactory
import org.scalatra.BadRequest

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext

/**
  * @author Brian Schlining
  * @since 2016-12-14T15:27:00
  */
class LinkApi(daoFactory: DAOFactory)(implicit val executor: ExecutionContext) extends ApiStack {


  before() {
    contentType = "application/json"
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }

  get("/:name") {
    val name = params.get("name")
      .getOrElse(halt(BadRequest("Please provide a term to look up")))
    val dao = daoFactory.newLinkNodeDAO()
    dao.findAllApplicableTo(name)
        .map(_.asJava)
        .map(toJson)
  }

}