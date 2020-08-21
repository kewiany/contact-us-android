package xyz.kewiany.contactus.logic.common

class CommonViewState {
    var isLoading: Boolean = false
}

class MainViewState(val commonViewState: CommonViewState = CommonViewState()) : ViewState