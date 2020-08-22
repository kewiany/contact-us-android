package xyz.kewiany.contactus.logic

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.rx3.awaitFirst
import xyz.kewiany.contactus.core.DefaultDispatcherProvider
import xyz.kewiany.contactus.core.DispatcherProvider
import xyz.kewiany.contactus.core.createState
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.ViewState

sealed class FAQAction : Action {
    object SelectBack : FAQAction()
}

class FAQViewState : ViewState {
    var items = createState<List<String>>()
}

suspend fun FAQViewState.FAQLogic(
    actions: Observable<FAQAction>,
    dispatchers: DispatcherProvider = DefaultDispatcherProvider()
) {
    actions.awaitFirst()
}
