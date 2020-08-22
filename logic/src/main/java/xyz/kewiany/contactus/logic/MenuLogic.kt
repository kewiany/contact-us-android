package xyz.kewiany.contactus.logic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.ofType
import kotlinx.coroutines.rx3.awaitFirst
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.ViewState

sealed class MenuAction : Action {
    object SelectBack : MenuAction()
    object SelectFAQ : MenuAction()
}

class MenuViewState : ViewState {
    val faqViewState = FAQViewState()
}

suspend fun MenuViewState.MenuLogic(
    actions: Observable<MenuAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    when (actions.awaitFirst()) {
        MenuAction.SelectFAQ -> faqViewState.FAQLogic(actions.ofType(), dispatchers)
    }
}
