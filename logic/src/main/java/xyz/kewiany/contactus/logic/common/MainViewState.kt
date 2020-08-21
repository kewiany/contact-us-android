package xyz.kewiany.contactus.logic.common

import com.jakewharton.rxrelay3.BehaviorRelay
import xyz.kewiany.contactus.core.createState

class CommonViewState {
    var isLoading: BehaviorRelay<Boolean> = createState(false)
}

class MainViewState(val commonViewState: CommonViewState = CommonViewState()) : ViewState
