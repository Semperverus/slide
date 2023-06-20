package ltd.ucode.reddit.data

import kotlinx.datetime.Instant
import ltd.ucode.slide.data.IPost
import net.dean.jraw.models.CommentNode
import net.dean.jraw.models.Submission

class RedditSubmission(val data: Submission) : IPost() {
    override val id: String
        get() = data.id

    override val title: String
        get() = data.title

    override val url: String?
        get() = data.url

    override val body: String?
        get() = data.selftext

    override val isLocked: Boolean
        get() = data.isLocked

    override val groupName: String
        get() = data.subredditName

    override val permalink: String
        get() = data.fullName // on reddit: Kind + UniqueId

    override val isArchived: Boolean
        get() = data.isArchived

    override val isContest: Boolean
        get() = data.dataNode["contest_mode"].asBoolean()

    override val published: Instant
        get() = Instant.fromEpochMilliseconds(data.created.time)

    override val comments: Iterable<CommentNode>
        get() = data.comments
}
