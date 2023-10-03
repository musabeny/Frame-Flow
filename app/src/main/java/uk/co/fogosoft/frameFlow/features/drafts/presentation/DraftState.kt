package uk.co.fogosoft.frameFlow.features.drafts.presentation

import uk.co.fogosoft.frameFlow.core.util.DraftDetails

data class DraftState(
    val list:List<DraftDetails> = emptyList()
)
