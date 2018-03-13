package utils.splunk;

import java.util.ArrayList;
import java.util.List;

/**********************************************************************
 * ENUM: Holds all event message strings and fields.
 *
 * @author Software Quality Engineering Team NBCUniversal Technology - Digital
 * Products & Interactive Media
 * @since October 31, 2014  
 **************************************************************************/
public enum EventFields {
    INVALID_INITIAL_VALUE("\"Initial Ingest Validation Failure. Invalid <property_name>. Ingest failed.\""),
    MISSING_INITIAL_FIELD("\"Initial Ingest Validation Failure. Missing <property_name>. Ingest failed.\""),
    RESPONSE_INVALID_INITIAL_VALUE("Initial Ingest Validation Failure. Invalid <property_name>. Ingest failed."),
    RESPONSE_MISSING_INITIAL_FIELD("Initial Ingest Validation Failure. Missing <property_name>. Ingest failed."),
    MISSING_INGEST_FIELD("\"Ingest Failure. Missing <property_name>. Ingest failed.\""),
    MISSING_INGEST_FIELD_USED_FALLBACK("\"Ingest Error. Missing <property_name>. Used fallback rule.\""),
    INVALID_INGEST_FIELD("\"Ingest Failure. Invalid <property_name>. Ingest failed.\""),
    CANNOT_FIND_INGEST_FIELD_REFERENCE("\"Ingest Error. <property_name> <referencedGuid> could not be found, used fallback rule.\""),
    CANNOT_FIND_INGEST_FIELD_REFERENCE_FAIL("\"Ingest Error. <property_name> <referencedGuid> could not be found. Ingest failed.\""),
    CANNOT_FIND_INGEST_FIELD_REFERENCE_NULL("\"Ingest Error. <property_name> <referencedGuid> could not be found, treated as null.\""),
    EMBEDDED_IMAGE_CANNOT_RESOLVE_REFERENCE("\"Ingest Error. image <referencedGuid> could not be found, treated as null.\""),
    MISSING_INGEST_FIELD_REFERENCE_NULL("\"Ingest Error. Missing <property_name>. Treated as null.\""),
    WARN_BATCH_CALL_IMG_OBJECT("\"Ingest Error. Batch call for Image Object <referencedGuid> could not be resolved, treated as null.\""),
    ERR_BATCH_CALL_COULD_NOT_BE_RESOLVED_TAXO("\"Ingest Error. Batch call for <objectTypeName> <referencedGuidList> could not be resolved, used fallback rule when possible.\""),
    MISSING_OPTIONAL_INGEST_FIELD("\"Ingest Warning. Missing <property_name>.\""),
    WARN_CANNOT_RESOLVE_REFERENCE("\"Ingest Warning. <property_name> <referencedGuid> could not be found. Continued processing message, but referenced object may not appear in final render unless issue is resolved.\""),
    WARN_INVALID_PROPERTY_VALUE_IGNORE("\"Ingest Warning. Invalid <property_name>. Ingest continued ignoring incorrect value <property_value>.\""),
    WARN_INVALID_PROPERTY_VALUE_FALLBACK("\"Ingest Warning. Invalid <property_name> value <property_value>. Ingest continued using fallback rule.\""),
    WARN_INVALID_PROPERTY_VALUE("\"Ingest Warning. Invalid <property_name> value <property_value>. Ingest continued.\""),
    WARN_INVALID_PROPERTY_VALUE_WITH_TYPE("\"Ingest Warning. <objectTypeName> corresponding to <property_name> value <property_value> was not found, treated as null. Ingest continued.\""),
    WARN_NOT_A_VALID_GUID("\"Ingest Warning. The reference in <property_name> value <property_value> is not a valid CW GUID. Treated as null. Ingest continued.\""),
    WARN_BATCH_CALL_COULD_NOT_BE_RESOLVED("\"Ingest Warning. Batch call for <objectTypeName> <referencedGuidList> could not be resolved. Continued processing message, but referenced object may not appear in final render unless issue is resolved.\""),
    WARN_BATCH_CALL_COULD_NOT_BE_RESOLVED_TAXO("\"Ingest Warning. Batch call for <objectTypeName> <referencedGuidList> could not be resolved. Continued processing message, but referenced object may not appear in final render unless issue is resolved.\""),
    WARN_BAD_REQUEST("\"Ingest Warning. Invalid path. Ingest continued ignoring incorrect value null.\""),
    UNABLE_TO_PARSE_CAPTIONS("\"Unable to parse captions from: <property_name> value <property_value>.\""),
    INVALID_ID("\"Invalid id: <referencedGuid>\""),
    MISSING_NAME("\"Required String parameter '<field>' is not present\""),
    SCM_COMPLETE("\"Standard Content Model message completed.\""),
    VALID_INITIAL_MESSAGE("\"NewsCMS message received.\""),
    EVENT_OP_CAPTION_CALL("captionCall"),
    EVENT_OP_INITIALVALIDATION("initialValidation"),
    EVENT_OP_PROVIDERMESSAGERECEIPT("providerMessageReceipt"),
    EVENT_OP_OUTGOINGSCMMESSAGERECEIPT("outgoingScmMessageReceipt"),
    EVENT_OP_CMSVALIDATION("cmsValidation"),
    EVENT_OP_SCMREFLOOKUP("scmRefLookup"),
    EVENT_OP_CONTENT_WAREHOUSE_API_CALL("contentWarehouseAPICall"),
    EVENT_OP_SENDNOTIFICATION("sendNotification"),
    EVENT_OP_INCOMINGSCMMESSAGERECEIPT("incomingScmMessageReceipt"),
    EVENT_OP_SCMSAVEDTODB("scmSavedToDB"),
    EVENT_OP_SCMUPDATEDTODB("scmUpdatedInDB"),
    EVENT_OP_SCMDELETEDFROMDB("scmDeletedFromDB"),
    EVENT_OP_DOCUMENTSUBMITTEDFORINDEXING("documentSubmittedForIndexing"),
    EVENT_OP_DOCUMENTSUBMITTEDFORREINDEXING("documentReferencesSubmittedForReindexing"),
    EVENT_OP_FINISHEDPROCESSINGMESSAGE("finishedProcessingMessage"),
    EVENT_OP_TOTAL_DOCUMENTS_SUBMITTED_FOR_REINDEXING("totalDocumentsSubmittedForReindexing"),
    CAUSE_SCM_DOCUMENT_RECEIVED("\"SCM document received.\""),
    CAUSE_CREATED_SCM_DOCUMENT_IN_MONGODB("\"Created SCM document in MongoDB.\""),
    CAUSE_UPDATED_SCM_DOCUMENT_IN_MONGODB("\"Updated SCM document in MongoDB.\""),
    CAUSE_DELTED_SCM_DOCUMENT_IN_MONGODB("\"Deleted SCM document in MongoDB.\""),
    CAUSE_DOCUMENT_SUBMITTED_FOR_INDEXING("\"Document submitted for indexing in Elastic Search.\""),
    CAUSE_DOCUMENT_SUBMITTED_FOR_REINDEXING("\"Document references submitted for reindexing in Elastic Search.\""),
    CAUSE_PROCESSING_FINISHED_MESSAGE("\"Finished processing.\""),
    CAUSE_TOTAL_REFERENCED_DOCUMENTS_SUBMITTED_IS("\"Total referenced documents submitted for reindexing is %d.\""),
    CAUSE_NOTIFICATION_SUCCESSFULLY_SENT("\"SNS notification successfully sent.\""),
    EVENT_SEVERITY_ERROR("error"),
    EVENT_SEVERITY_INFO("info"),
    EVENT_SEVERITY_WARN("warn"),
    EVENT_NULL("null"),
    EVENT_LOG_CONTENT("content"),
    EVENT_LOG_GUID("guid"),
    EVENT_LOG_MESSAGE_ID("messageId"),
    EVENT_LOG_TIMESTAMP("timestamp"),
    EVENT_LOG_CAUSE("cause"),
    EVENT_LOG_OP("op"),
    EVENT_LOG_STATUS("status"),
    EVENT_LOG_SEVERITY("severity"),
    EVENT_LOG_BUILDVERSION("buildVersion"),
    EVENT_LOG_INGESTEND("ingestEnd"),
    EVENT_LOG_INGESTSTART("ingestStart"),
    EVENT_PERF_DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSX"),
    EVENT_RAW("_raw"),
    EVENT_PARTS_DELIMETER(";"),
    EVENT_EQUAL("=");

    private String field;

    EventFields(final String fieldName) {
        this.field = fieldName;
    }

    public String getField() {
        return field;
    }

    public static List<String> getEventLogFields() {
        ArrayList<String> eventLogFields = new ArrayList<>();
        eventLogFields.add(EventFields.EVENT_LOG_GUID.getField());
        eventLogFields.add(EventFields.EVENT_LOG_TIMESTAMP.getField());
        eventLogFields.add(EventFields.EVENT_LOG_CAUSE.getField());
        eventLogFields.add(EventFields.EVENT_LOG_OP.getField());
        eventLogFields.add(EventFields.EVENT_LOG_STATUS.getField());
        eventLogFields.add(EventFields.EVENT_LOG_SEVERITY.getField());
        eventLogFields.add(EventFields.EVENT_LOG_BUILDVERSION.getField());
        eventLogFields.add(EventFields.EVENT_LOG_MESSAGE_ID.getField());
        return eventLogFields;
    }
}
