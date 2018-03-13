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
    /**
     * Invalid value of message field.
     **/
    INVALID_INITIAL_VALUE("\"Initial Ingest Validation Failure. Invalid <property_name>. Ingest failed.\""),
    /**
     * Missing required message field.
     **/
    MISSING_INITIAL_FIELD("\"Initial Ingest Validation Failure. Missing <property_name>. Ingest failed.\""),
    /**
     * Invalid value of message field.
     **/
    RESPONSE_INVALID_INITIAL_VALUE("Initial Ingest Validation Failure. Invalid <property_name>. Ingest failed."),
    /**
     * Missing required message field.
     **/
    RESPONSE_MISSING_INITIAL_FIELD("Initial Ingest Validation Failure. Missing <property_name>. Ingest failed."),
    /**
     * Missing required message field.
     **/
    MISSING_INGEST_FIELD("\"Ingest Failure. Missing <property_name>. Ingest failed.\""),
    /**
     * Missing optional message field.
     **/
    MISSING_OPTIONAL_INGEST_FIELD("\"Ingest Warning. Missing <property_name>.\""),
    /**
     * Missing required message field. Special case where fallback rule is used.
     **/
    MISSING_INGEST_FIELD_USED_FALLBACK("\"Ingest Error. Missing <property_name>. Used fallback rule.\""),
    /**
     * Invalid required message field.
     **/
    INVALID_INGEST_FIELD("\"Ingest Failure. Invalid <property_name>. Ingest failed.\""),
    /**
     * Cannot find required message fields reference.
     **/
    CANNOT_FIND_INGEST_FIELD_REFERENCE(
            "\"Ingest Error. <property_name> <referencedGuid> could not be found, used fallback rule.\""),
    /**
     * Cannot find required message fields reference. Fails execution.
     **/
    CANNOT_FIND_INGEST_FIELD_REFERENCE_FAIL(
            "\"Ingest Error. <property_name> <referencedGuid> could not be found. Ingest failed.\""),
    /**
     * Cannot find required message fields reference, treated as null.
     **/
    CANNOT_FIND_INGEST_FIELD_REFERENCE_NULL(
            "\"Ingest Error. <property_name> <referencedGuid> could not be found, treated as null.\""),
    /**
     * Embedded image cannot resolve reference
     */
    EMBEDDED_IMAGE_CANNOT_RESOLVE_REFERENCE("\"Ingest Error. image <referencedGuid> "
            + "could not be found, treated as null.\""),

    /** Warn. Can't resolve referenced objects. */
    WARN_CANNOT_RESOLVE_REFERENCE("\"Ingest Warning. <property_name> <referencedGuid> could not be found. "
            + "Continued processing message, but referenced object may not "
            + "appear in final render unless issue is resolved.\""),

    /** Warn. Invalid property. */
    WARN_INVALID_PROPERTY_VALUE_IGNORE(
            "\"Ingest Warning. Invalid <property_name>. Ingest continued ignoring incorrect value <property_value>.\""),
    /** Warn. Invalid property. */
    WARN_INVALID_PROPERTY_VALUE_FALLBACK(
            "\"Ingest Warning. Invalid <property_name> value <property_value>. Ingest continued using fallback rule.\""),
    /** Warn. Invalid property. */
    WARN_INVALID_PROPERTY_VALUE("\"Ingest Warning. Invalid <property_name> value <property_value>. Ingest continued.\""),
    /** Warn. Invalid property. */
    WARN_INVALID_PROPERTY_VALUE_WITH_TYPE(
            "\"Ingest Warning. <objectTypeName> corresponding to <property_name> value <property_value> was not found, treated as null. Ingest continued.\""),

    WARN_NOT_A_VALID_GUID(
            "\"Ingest Warning. The reference in <property_name> value <property_value> is not a valid CW GUID. Treated as null. Ingest continued.\""),
    /**
     * Invalid ID error message.
     **/
    INVALID_ID("\"Invalid id: <referencedGuid>\""),
    /**
     * Missing name error message.
     **/
    MISSING_NAME("\"Required String parameter '<field>' is not present\""),
    /**
     * SCM message complete message.
     **/
    SCM_COMPLETE("\"Standard Content Model message completed.\""),

    UNABLE_TO_PARSE_CAPTIONS("\"Unable to parse captions from: <property_name> value <property_value>.\""),
    /**
     * Valid message receipt.
     **/
    VALID_INITIAL_MESSAGE("\"NewsCMS message received.\""),
    /**
     * Event log field, holds content of message.
     **/
    EVENT_LOG_CONTENT("content"),
    /**
     * Event log field, holds guid value.
     **/
    EVENT_LOG_GUID("guid"),
    /**
     * Event log field, holds messageId value.
     */
    EVENT_LOG_MESSAGE_ID("messageId"),
    /**
     * Event log field, holds timestamp of log message.
     **/
    EVENT_LOG_TIMESTAMP("timestamp"),
    /**
     * Event log field, holds event message.
     **/
    EVENT_LOG_CAUSE("cause"),
    /**
     * Event log field, holds operation value.
     **/
    EVENT_LOG_OP("op"),
    /**
     * Event log field, holds status code.
     **/
    EVENT_LOG_STATUS("status"),
    /**
     * Event log field, holds severity value.
     **/
    EVENT_LOG_SEVERITY("severity"),
    /**
     * Event log field, holds buildVersion value.
     **/
    EVENT_LOG_BUILDVERSION("buildVersion"),

    EVENT_OP_CAPTION_CALL("captionCall"),
    /**
     * Event log value of the field - op.
     **/
    EVENT_OP_INITIALVALIDATION("initialValidation"),
    /**
     * Event log value of the field - op.
     **/
    EVENT_OP_PROVIDERMESSAGERECEIPT("providerMessageReceipt"),
    /**
     * Event log value of the field - op.
     **/
    EVENT_OP_OUTGOINGSCMMESSAGERECEIPT("outgoingScmMessageReceipt"),
    /**
     * Event log value of the field - op.
     **/
    EVENT_OP_CMSVALIDATION("cmsValidation"),
    /**
     * Event log value of the field - op.
     **/
    EVENT_OP_SCMREFLOOKUP("scmRefLookup"),
    /**
     * Event log value of the field - op.
     **/
    EVENT_OP_CONTENT_WAREHOUSE_API_CALL("contentWarehouseAPICall"),
    /**
     * Event log value - error.
     **/
    EVENT_SEVERITY_ERROR("error"),
    /**
     * Event log value - info.
     **/
    EVENT_SEVERITY_INFO("info"),
    /**
     * Event log value - warn.
     **/
    EVENT_SEVERITY_WARN("warn"),
    /**
     * Event log value - null
     **/
    EVENT_NULL("null"),
    /**
     * Event log field, holds ingestEnd message.
     **/
    EVENT_LOG_INGESTEND("ingestEnd"),
    /**
     * Event log field, holds ingestStart message.
     **/
    EVENT_LOG_INGESTSTART("ingestStart"),
    /**
     * Perf timestamp Date format.
     **/
    EVENT_PERF_DATE_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSX"),

    EVENT_RAW("_raw"),
    EVENT_PARTS_DELIMETER(";"),
    EVENT_EQUAL("="),

    /** CW Intake Events **/
    /** Event Op - incomingScmMessageReceipt */
    EVENT_OP_SENDNOTIFICATION("sendNotification"),
    /** Event Op - incomingScmMessageReceipt */
    EVENT_OP_INCOMINGSCMMESSAGERECEIPT("incomingScmMessageReceipt"),
    /** Event Op -scmSavedToDB */
    EVENT_OP_SCMSAVEDTODB("scmSavedToDB"),
    /** Event Op - scmUpdatedInDB */
    EVENT_OP_SCMUPDATEDTODB("scmUpdatedInDB"),
    /** Event Op - scmDeletedFromDB */
    EVENT_OP_SCMDELETEDFROMDB("scmDeletedFromDB"),
    /** Event Op - documentSubmittedForIndexing */
    EVENT_OP_DOCUMENTSUBMITTEDFORINDEXING("documentSubmittedForIndexing"),
    /** Event Op - documentSubmittedForReindexing */
    EVENT_OP_DOCUMENTSUBMITTEDFORREINDEXING("documentReferencesSubmittedForReindexing"),
    /** Event Op - finishedProcessingMessage */
    EVENT_OP_FINISHEDPROCESSINGMESSAGE("finishedProcessingMessage"),
    /** Event Op - totalDocumentsSubmittedForReindexing */
    EVENT_OP_TOTAL_DOCUMENTS_SUBMITTED_FOR_REINDEXING("totalDocumentsSubmittedForReindexing"),
    /** SCM document received. **/
    CAUSE_SCM_DOCUMENT_RECEIVED("\"SCM document received.\""),
    /** Created SCM document in MongoDB. */
    CAUSE_CREATED_SCM_DOCUMENT_IN_MONGODB("\"Created SCM document in MongoDB.\""),
    /** Updated SCM document in MongoDB. */
    CAUSE_UPDATED_SCM_DOCUMENT_IN_MONGODB("\"Updated SCM document in MongoDB.\""),
    /** Deleted SCM document in MongoDB. */
    CAUSE_DELTED_SCM_DOCUMENT_IN_MONGODB("\"Deleted SCM document in MongoDB.\""),
    /** Document submitted for indexing in Elastic Search. */
    CAUSE_DOCUMENT_SUBMITTED_FOR_INDEXING("\"Document submitted for indexing in Elastic Search.\""),
    /** Document submitted for Reindexing in Elastic Search. */
    CAUSE_DOCUMENT_SUBMITTED_FOR_REINDEXING("\"Document references submitted for reindexing in Elastic Search.\""),
    /** Document submitted for indexing in Elastic Search. */
    CAUSE_PROCESSING_FINISHED_MESSAGE("\"Finished processing.\""),
    /** Document submitted for indexing in Elastic Search. */
    CAUSE_TOTAL_REFERENCED_DOCUMENTS_SUBMITTED_IS("\"Total referenced documents submitted for reindexing is %d.\""),
    /** Notification successfully sent. */
    CAUSE_NOTIFICATION_SUCCESSFULLY_SENT("\"SNS notification successfully sent.\""),

    MISSING_INGEST_FIELD_REFERENCE_NULL("\"Ingest Error. Missing <property_name>. Treated as null.\""),

    /** Warn. Batch call could not be resolved. */
    WARN_BATCH_CALL_COULD_NOT_BE_RESOLVED(
            "\"Ingest Warning. Batch call for <objectTypeName> <referencedGuidList> could not be resolved. "
                    + "Continued processing message, but referenced object may not appear in final render unless issue is resolved.\""),
    /** Warn. Batch call could not be resolved. */
    /** Articles Taxonomies Error. Batch call could not be resolved. */
    ERR_BATCH_CALL_COULD_NOT_BE_RESOLVED_TAXO(
            "\"Ingest Error. Batch call for <objectTypeName> <referencedGuidList> could not be resolved, used fallback rule when possible.\""),
    /** Reference Taxonomies Warn. Batch call could not be resolved. */
    WARN_BATCH_CALL_COULD_NOT_BE_RESOLVED_TAXO(
            "\"Ingest Warning. Batch call for <objectTypeName> <referencedGuidList> could not be resolved. Continued processing message, "
                    + "but referenced object may not appear in final render unless issue is resolved.\""),
    /** Warn. Batch call could not be resolved. */
    WARN_BATCH_CALL_IMG_OBJECT(
            "\"Ingest Error. Batch call for Image Object <referencedGuid> could not be resolved, treated as null.\""),
    /** Warn. Bad Request */
    WARN_BAD_REQUEST("\"Ingest Warning. Invalid path. Ingest continued ignoring incorrect value null.\""),

    /** objectTypeName used for news articles */
    OBJECT_TYPE_NAME_NEWS_ARTICLES("NewsArticles"),
    /** objectTypeName used for lists */
    OBJECT_TYPE_NAME_LISTS("Lists"),
    /** objectTypeName used for taxonomies */
    OBJECT_TYPE_NAME_TAXONOMIES("Taxonomies"),
    /** objectTypeName used for persons */
    OBJECT_TYPE_NAME_PERSONS("Persons"),
    /** objectTypeName used for organizations */
    OBJECT_TYPE_NAME_ORGANIZATIONS("Organizations"),
    /** objectTypeName used for widget definitions */
    OBJECT_TYPE_NAME_WIDGETS("WidgetDefinitions"),
    /** objectTypeName used for images */
    OBJECT_TYPE_NAME_IMAGES("Images"),
    /** objectTypeName used for image objects */
    OBJECT_TYPE_NAME_IMAGE_OBJ("Image Object"),
    /** objectTypeName used for videos */
    OBJECT_TYPE_NAME_VIDEOS("Videos"),
    /** objectTypeName used for videos */
    OBJECT_TYPE_NAME_SLIDESHOWS("Slideshows"),
    /** objectTypeName used for recipes */
    OBJECT_TYPE_NAME_RECIPIES("Recipies"),
    /** objectTypeName used for cards */
    OBJECT_TYPE_NAME_CARDS("Cards");

    /**
     * value of each enum entry.
     **/
    private String field;

    /**
     * Constructor to initialize enum values.
     *
     * @param fieldName - setting field
     **/
    EventFields(final String fieldName) {
        this.field = fieldName;
    }

    /**
     * Accessor method to retrieve value.
     *
     * @return String - value of calling Enum field
     **/
    public String getField() {
        return field;
    }

    /**
     * Returns the event log fields.
     *
     * @return List<String> - list of event log fields
     **/
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
