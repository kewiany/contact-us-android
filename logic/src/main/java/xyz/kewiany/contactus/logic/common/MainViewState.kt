package xyz.kewiany.contactus.logic.common

import xyz.kewiany.contactus.core.createState

class CommonViewState : ViewState {
    var isLoading = createState(false)
}

class FAQViewState : ViewState {
    var items = createState<List<String>>()
}

class MainViewState {
    val commonViewState = CommonViewState()
    val faqViewState = FAQViewState()
}
