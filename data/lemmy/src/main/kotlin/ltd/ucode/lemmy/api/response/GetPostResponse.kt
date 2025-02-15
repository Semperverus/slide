package ltd.ucode.lemmy.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ltd.ucode.lemmy.data.type.CommunityModeratorView
import ltd.ucode.lemmy.data.type.CommunityView
import ltd.ucode.lemmy.data.type.PostView

@Serializable
data class GetPostResponse(
    @SerialName("community_view") val communityView: CommunityView,
    val moderators: List<CommunityModeratorView>,
    val online: Int = -1, // REMOVED in 0.18.0
    @SerialName("post_view") val postView: PostView,
) {
}
