package se2.SafeStreets.back.model.Dto

import se2.SafeStreets.back.model.ViolationReport
import se2.SafeStreets.back.model.ViolationReportStatus
import se2.SafeStreets.back.model.ViolationType
import java.time.LocalDateTime

class ViolationReportDto() {

    lateinit var description: String
    lateinit var dateTime: LocalDateTime
    lateinit var type: ViolationType
    lateinit var location: Array<Double>
    lateinit var status: ViolationReportStatus
    var confidence: Float? = null

    constructor(description: String, dateTime:LocalDateTime, type: ViolationType, location: Array<Double>, status: ViolationReportStatus, confidence: Float? = null) : this() {
        this.description = description
        this.dateTime = dateTime
        this.type = type
        this.location = location
        this.status = status
        this.confidence = confidence
    }

    companion object {
        fun fromReport(report: ViolationReport): ViolationReportDto {
            return ViolationReportDto(report.description, report.dateTime, report.type, report.location.coordinates, report.status, report.confidence)
        }
    }
}