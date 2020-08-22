package xyz.kewiany.contactus.logic

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.rx3.awaitFirst
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.ViewState

sealed class MenuAction : Action {
    object SelectBack : MenuAction()
}

class MenuViewState : ViewState

suspend fun MenuViewState.MenuLogic(
    actions: Observable<MenuAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    actions.awaitFirst()
}
