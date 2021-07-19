package com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels

import androidx.lifecycle.MutableLiveData
import com.cajusoftware.apps.android.lottieapplication.features.road.api.repositories.CatRepository
import com.cajusoftware.apps.android.lottieapplication.features.road.api.viewmodels.utils.mockFakeResponseSuccessfully
import com.cajusoftware.apps.android.lottietest.rules.CoroutineScopeRule
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CatViewModelImplTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineScope = CoroutineScopeRule.create()

    private val repository: CatRepository = mockk()

    private lateinit var viewModel: CatViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = CatViewModelImpl(repository)

    }

    @Test
    fun `when call getData should return successfully`() =
        runBlocking(Dispatchers.Main) {

            coEvery {
                repository.getData()
            } returns mockFakeResponseSuccessfully()

            viewModel.getData()

            coVerify(exactly = 1) {
                repository.getData()
            }
        }
}