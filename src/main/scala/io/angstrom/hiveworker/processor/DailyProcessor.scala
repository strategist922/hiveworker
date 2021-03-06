package io.angstrom.hiveworker.processor

import io.angstrom.hiveworker.util.JobType
import org.springframework.context.ApplicationContext

class DailyProcessor(applicationContext: Option[ApplicationContext])
  extends JobProcessor(applicationContext) {
  def jobType = JobType.DAILY
}
