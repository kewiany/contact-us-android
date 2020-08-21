package xyz.kewiany.contactus.logic.common

import com.jakewharton.rxrelay3.BehaviorRelay

class CommonViewState {
    var isLoading: BehaviorRelay<Boolean> = BehaviorRelay.createDefault(false)
}

class MainViewState(val commonViewState: CommonViewState = CommonViewState()) : ViewState
