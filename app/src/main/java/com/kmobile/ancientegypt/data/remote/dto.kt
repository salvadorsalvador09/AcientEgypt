package com.kmobile.ancientegypt.data.remote

import com.fasterxml.jackson.annotation.JsonProperty

class dto{

data class MetObjectDto(
    val total: Int,
    val objectIDs: List<Int>,
)

data class MetObjectDetailDto(
    @JsonProperty("objectID")
    val objectId: Long,
    val isHighlight: Boolean,
    val accessionNumber: String,
    val accessionYear: String,
    val isPublicDomain: Boolean,
    val primaryImage: String,
    val primaryImageSmall: String,
    val additionalImages: List<String>,
    val constituents: List<Constituent>?,
    val department: String,
    val objectName: String,
    val title: String,
    val culture: String,
    val period: String,
    val dynasty: String,
    val reign: String,
    val portfolio: String,
    val artistRole: String,
    val artistPrefix: String,
    val artistDisplayName: String,
    val artistDisplayBio: String,
    val artistSuffix: String,
    val artistAlphaSort: String,
    val artistNationality: String,
    val artistBeginDate: String,
    val artistEndDate: String,
    val artistGender: String,
    @JsonProperty("artistWikidata_URL")
    val artistWikidataUrl: String,
    @JsonProperty("artistULAN_URL")
    val artistUlanUrl: String,
    val objectDate: String,
    val objectBeginDate: Long,
    val objectEndDate: Long,
    val medium: String,
    val dimensions: String,
    val measurements: List<Measurement>,
    val creditLine: String,
    val geographyType: String,
    val city: String,
    val state: String,
    val county: String,
    val country: String,
    val region: String,
    val subregion: String,
    val locale: String,
    val locus: String,
    val excavation: String,
    val river: String,
    val classification: String,
    val rightsAndReproduction: String,
    val linkResource: String,
    val metadataDate: String,
    val repository: String,
    @JsonProperty("objectURL")
    val objectUrl: String,
    val tags: List<Tag>,
    @JsonProperty("objectWikidata_URL")
    val objectWikidataUrl: String,
    val isTimelineWork: Boolean,
    @JsonProperty("GalleryNumber")
    val galleryNumber: String,
)

data class Constituent(
    @JsonProperty("constituentID")
    val constituentId: Long,
    val role: String,
    val name: String,
    @JsonProperty("constituentULAN_URL")
    val constituentUlanUrl: String,
    @JsonProperty("constituentWikidata_URL")
    val constituentWikidataUrl: String,
    val gender: String,
)

data class Measurement(
    val elementName: String,
    val elementDescription: String?,
    val elementMeasurements: ElementMeasurements,
)

data class ElementMeasurements(
    @JsonProperty("Height")
    val height: Double,
    @JsonProperty("Length")
    val length: Double,
    @JsonProperty("Width")
    val width: Double,
)

data class Tag(
    val term: String,
    @JsonProperty("AAT_URL")
    val aatUrl: String,
    @JsonProperty("Wikidata_URL")
    val wikidataUrl: String,
)



}
