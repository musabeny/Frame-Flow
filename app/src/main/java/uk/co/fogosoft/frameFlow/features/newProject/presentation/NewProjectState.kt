package uk.co.fogosoft.frameFlow.features.newProject.presentation

import uk.co.fogosoft.frameFlow.core.util.DraftDetails
import uk.co.fogosoft.frameFlow.features.newProject.domain.model.ImageResource

data class NewProjectState(
    val data:String = "",
    val images: List<ImageResource> = emptyList(),
    val firstDrafts:List<DraftDetails> = emptyList(),
    val secondDraft:List<DraftDetails> = emptyList()
)
