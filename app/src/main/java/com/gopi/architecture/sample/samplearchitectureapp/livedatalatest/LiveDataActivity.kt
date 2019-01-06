package com.gopi.architecture.sample.samplearchitectureapp.livedatalatest

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.databinding.ActivityLiveDataBinding

/*
questions:
. livedata is like a behavioural subject ? { YES correct }, upon coming back data u will receive updated data.
. how can i have nested view models so that Page A & Page B can have some part common without completely depending on Single viewmodel ?
. Extending LiveData usecase for multiple activities sharing common state. & also practise it
. how can i make same viewmodel for different activities.
. ViewModelProvider.of(Fragment/Activity, Factory) -> what is the use of Factory in that.
. private lateinit var sInstance: StockLiveData  ; if(::sInstance.isInitialized)  -> what is :: here.

******************************* To do practise *******************************
. Write a customView which extends constraintLayout & get better understanding of how this is done.
. Write livecycleowner for a customView instead of activity or fragment.
.

************************************************************ Imp Points ************************************************************
1) To use same viewmodel among different fragments of same activity use ViewModelsProvider.of(getActivity).get(...) instead of .of("this").get

2) class MyViewModel(private val repository: PostalCodeRepository) : ViewModel() {

    private fun getPostalCode(address: String): LiveData<String> {  // Never write method returning livedata as The UI component then needs to unregister from the previous LiveData object and register to the 																//new instance each time it calls getPostalCode(). In addition, if the UI component is recreated, it triggers another call to the
    																//repository.getPostCode() method instead of using the previous call’s result.
        // DON'T DO THIS
        return repository.getPostCode(address)
    }
}

// Do this
class MyViewModel(private val repository: PostalCodeRepository) : ViewModel() {
    private val addressInput = MutableLiveData<String>()
    private val postalCode: LiveData<String> =
            Transformations.switchMap(addressInput) { address -> repository.getPostCode(address) }    // instead of returning LiveData just use transformation.


    private fun setInput(address: String) {
        addressInput.value = address
    }
}
* */

class LiveDataActivity : AppCompatActivity() {
    lateinit var firstLiveData: FirstLiveData
    lateinit var binding: ActivityLiveDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)
        doInit()
        doLogic()
    }

    private fun doInit() {
        firstLiveData = ViewModelProviders.of(this).get(FirstLiveData::class.java)
        binding.setLifecycleOwner(this)   // Set this line to make data binding use live data.
        binding.livedataVM = firstLiveData
        firstLiveData.doSomeProcessing()

        /*firstLiveData.name.observe(this , Observer {   // no need of this if u r just using to update the ui.
//            liveDataTv.text = it
            Toast.makeText(this,"value is $it", Toast.LENGTH_LONG).show()
        })*/
    }

    private fun doLogic() {

    }
}
