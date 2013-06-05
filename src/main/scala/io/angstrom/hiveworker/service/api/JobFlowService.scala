package io.angstrom.hiveworker.service.api

import com.amazonaws.services.elasticmapreduce.model.JobFlowDetail
import io.angstrom.hiveworker.HiveEnvironment
import java.util.Date
import scala.concurrent.Future
import scala.util.Try

trait JobFlowService {
  def hiveEnvironment: Option[HiveEnvironment]
  def hiveEnvironment_= (hiveEnvironment: Option[HiveEnvironment])

  def submitJobFlow(attempt: Integer, jobFlow: JobFlow): Future[Try[SubmitJobFlowResult]]

  def describeJobFlow(jobFlowId: String): Future[Try[JobFlowDetail]]

  def describeJobFlows(
    createdAfter: Option[Date] = None,
    createdBefore: Option[Date] = None,
    jobFlowIds: Seq[String] = Seq[String](),
    jobFlowStates: Seq[String] = Seq[String]()
  ): Future[Try[Seq[JobFlowDetail]]]

  def terminateJobFlows(jobFlowId: String*)
}
