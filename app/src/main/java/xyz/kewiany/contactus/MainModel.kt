package xyz.kewiany.contactus

import com.jakewharton.rxrelay3.PublishRelay
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import xyz.kewiany.contactus.logic.MainLogic
import xyz.kewiany.contactus.logic.common.Action
import xyz.kewiany.contactus.logic.common.MainViewState

interface MainModelContract {
    val actions: PublishRelay<Action>
    val state: MainViewState
}

class MainModel : MainModelContract {
    override val actions: PublishRelay<Action> = PublishRelay.create()
    override val state = MainViewState()

    private val scope = MainScope()

    init {
        scope.launch {
            state.MainLogic(actions)
        }
    }
}
