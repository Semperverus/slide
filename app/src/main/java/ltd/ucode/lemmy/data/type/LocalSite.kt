package ltd.ucode.lemmy.data.type

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalSite (
    @SerialName("actor_name_max_length") val actorNameMaxLength: Int,
    @SerialName("application_email_admins") val isApplication: Boolean,
    @SerialName("application_question") val applicationQuestion: String?,
    @SerialName("captcha_difficulty") val captchaDifficulty: String,
    @SerialName("captcha_enabled") val isCaptchaEnabled: Boolean,
    @SerialName("community_creation_admin_only") val isCommunityCreationAdminOnly: Boolean,
    @SerialName("default_post_listing_type") val defaultPostListingType: String,
    @SerialName("default_theme") val defaultTheme: String,
    @SerialName("enable_downvotes") val isDownvoteEnabled: Boolean,
    @SerialName("enable_nsfw") val isNsfwEnabled: Boolean,
    @SerialName("federation_debug") val isFederationDebugMode: Boolean,
    @SerialName("federation_enabled") val isFederationEnabled: Boolean,
    @SerialName("federation_worker_count") val federationWorkerCount: Int,
    @SerialName("hide_modlog_mod_names") val isHiddenModlogModNames: Boolean,
    val id: Int,
    @SerialName("legal_information") val legalInformation: String?,
    @SerialName("private_instance") val isPrivateInstance: Boolean,
    val published: Instant,
    @SerialName("registration_mode") val registrationMode: RegistrationMode,
    @SerialName("reports_email_admins") val isReportingEmailedToAdmins: Boolean,
    @SerialName("require_email_verification") val isRequireEmailVerification: Boolean,
    @SerialName("site_id") val siteId: Int,
    @SerialName("site_setup") val isInSiteSetup: Boolean,
    @SerialName("slur_filter_regex") val slurFilterRegex: String?,
    val updated: Instant?,
)
