package xyz.kewiany.contactus.logic.common

import xyz.kewiany.contactus.core.createState
import xyz.kewiany.contactus.logic.menu.MenuViewState

class CommonViewState : ViewState {
    var isLoading = createState(false)
}

class MainViewState {
    val commonViewState = CommonViewState()
    val menuState = MenuViewState()
}
