package com.bmk.daggerproject.domain

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @JvmField @SerializedName("results")
    val results: List<ItemList>
)

data class ItemList(

    @JvmField @SerializedName("thumbnail")
    val thumbnail: String? = null,

    @JvmField @SerializedName("expert")
    val expert: Expert? = null,

    @JvmField @SerializedName("product_url")
    val productUrl: String? = null,

    @JvmField @SerializedName("item_type")
    val itemType: Int? = null,

    @JvmField @SerializedName("description")
    val description: String? = null,

    @JvmField @SerializedName("language")
    val language: String? = null,

    @JvmField @SerializedName("video")
    val video: Video? = null,

    @JvmField @SerializedName("title")
    val title: String? = null,

    @JvmField @SerializedName("uid")
    val uid: String? = null,

    @JvmField @SerializedName("score")
    val score: Double? = null,

    @JvmField @SerializedName("action_counts")
    val actionCounts: ActionCounts? = null,

    @JvmField @SerializedName("is_like")
    val isLike: Any? = null,

    @JvmField @SerializedName("publisher")
    val publisher: Publisher? = null,

    @JvmField @SerializedName("post_type")
    val postType: Any? = null,

    @JvmField @SerializedName("category")
    val category: List<String?>? = null,

    @JvmField @SerializedName("published_at")
    val publishedAt: String? = null,

    @JvmField @SerializedName("slug")
    val slug: String? = null
)

data class ExpertCategoriesItem(

    @JvmField @SerializedName("image_url")
    val imageUrl: String? = null,

    @JvmField @SerializedName("name")
    val name: String? = null,

    @JvmField @SerializedName("description")
    val description: Any? = null,

    @JvmField @SerializedName("language")
    val language: String? = null,

    @JvmField @SerializedName("id")
    val id: String? = null
)

data class Publisher(

    @JvmField @SerializedName("uid")
    val uid: String? = null,

    @JvmField @SerializedName("thumbnail")
    val thumbnail: String? = null,

    @JvmField @SerializedName("fragment")
    val fragment: Any? = null,

    @JvmField @SerializedName("section_id")
    val sectionId: Any? = null,

    @JvmField @SerializedName("name")
    val name: String? = null,

    @JvmField @SerializedName("description")
    val description: String? = null,

    @JvmField @SerializedName("is_subscribe")
    val isSubscribe: Boolean? = null,

    @JvmField @SerializedName("slug")
    val slug: String? = null
)

data class ExpertMisc(

    @JvmField @SerializedName("Years of Experience")
    val yearsOfExperience: String? = null,

    @JvmField @SerializedName("City of Residence")
    val cityOfResidence: String? = null,

    @JvmField @SerializedName("Number of Lives Touched")
    val numberOfLivesTouched: String? = null,

    @JvmField @SerializedName("No of Lives Touched")
    val noOfLivesTouched: String? = null
)

data class Video(

    @JvmField @SerializedName("duration")
    val duration: Int? = null,

    @JvmField @SerializedName("aspect_ratio")
    val aspectRatio: String? = null,

    @JvmField @SerializedName("transcoding_id")
    val transcodingId: String? = null,

    @JvmField @SerializedName("name")
    val name: String? = null,

    @JvmField @SerializedName("is_live")
    val isLive: Boolean? = null,

    @JvmField @SerializedName("state")
    val state: String? = null,

    @JvmField @SerializedName("media_details")
    val mediaDetails: List<Any?>? = null,

    @JvmField @SerializedName("shoot_location")
    val shootLocation: Any? = null
)

data class ActionCounts(

    @JvmField @SerializedName("like")
    var like: Int = 0,

    @JvmField @SerializedName("web_click")
    val webClick: Int? = null,

    @JvmField @SerializedName("share")
    val share: Int? = null,

    @JvmField @SerializedName("click")
    val click: Int? = null
)

data class Expert(

    @JvmField @SerializedName("is_tick_verified")
    val isTickVerified: Boolean? = null,

    @JvmField @SerializedName("payment_url")
    val paymentUrl: Any? = null,

    @JvmField @SerializedName("gender")
    val gender: Any? = null,

    @JvmField @SerializedName("city")
    val city: Any? = null,

    @JvmField @SerializedName("bio")
    val bio: String? = null,

    @JvmField @SerializedName("language")
    val language: String? = null,

    @JvmField @SerializedName("expert_verification_state")
    val expertVerificationState: Int? = null,

    @JvmField @SerializedName("is_expert")
    val isExpert: Boolean? = null,

    @JvmField @SerializedName("is_expert_live")
    val isExpertLive: Boolean? = null,

    @JvmField @SerializedName("id")
    val id: Int? = null,

    @JvmField @SerializedName("slug")
    val slug: String? = null,

    @JvmField @SerializedName("email")
    val email: String? = null,

    @JvmField @SerializedName("order")
    val order: Int? = null,

    @JvmField @SerializedName("short_bio")
    val shortBio: String? = null,

    @JvmField @SerializedName("profile_pic")
    val profilePic: String? = null,

    @JvmField @SerializedName("banner")
    val banner: String? = null,

    @JvmField @SerializedName("expert_categories")
    val expertCategories: List<ExpertCategoriesItem?>? = null,

    @JvmField @SerializedName("intro_video_url")
    val introVideoUrl: Any? = null,

    @JvmField @SerializedName("country_code")
    val countryCode: Any? = null,

    @JvmField @SerializedName("expert_misc")
    val expertMisc: Any? = null,

    @JvmField @SerializedName("known_languages")
    val knownLanguages: List<String?>? = null,

    @JvmField @SerializedName("user_id")
    val userId: String? = null,

    @JvmField @SerializedName("name")
    val name: String? = null,

    @JvmField @SerializedName("location") val location: Any? = null,

    @JvmField @SerializedName("is_profile_pic_set") val isProfilePicSet: Boolean? = null
)
