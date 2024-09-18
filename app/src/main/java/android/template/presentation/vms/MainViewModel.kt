package android.template.presentation.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rakuten.arch.core.datastore.repository.IUserPrefRepository
import io.rakuten.arch.core.datastore.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepo: IUserPrefRepository): ViewModel() {
	
	private var _userAgeData: MutableStateFlow<Int> = MutableStateFlow(0)
	val userAgeData: StateFlow<Int> = _userAgeData
	init {
		viewModelScope.launch(Dispatchers.IO) {
			_userAgeData.update { userRepo.getUserAge(Constants.KEY_USER_AGE).first() }
		}
	}
	suspend fun updateUserAgeData(userAge: Int) {
		userRepo.setUserAge(userAge)
	}
}