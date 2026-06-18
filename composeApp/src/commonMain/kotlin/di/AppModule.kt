package di

import com.spoonofcode.core.data.coroutines.di.coroutinesModule
import com.spoonofcode.core.firebase.data.di.firebaseDataModule
import com.spoonofcode.core.network.di.networkModule
import com.spoonofcode.core.presentation.di.presentationModule
import com.spoonofcode.core.recaptcha.di.recaptchaModule
import com.spoonofcode.core.session.data.di.sessionDataModule
import com.spoonofcode.core.session.domain.di.sessionDomainModule
import com.spoonofcode.core.storage.data.di.storageDataModule
import com.spoonofcode.feature.home.data.di.homeDataModule
import com.spoonofcode.feature.home.domain.di.homeDomainModule
import com.spoonofcode.feature.home.presentation.di.homePresentationModule
import com.spoonofcode.feature.notification.data.di.notificationDataModule
import com.spoonofcode.feature.notification.domain.di.notificationDomainModule
import com.spoonofcode.feature.notification.presentation.di.notificationPresentationModule
import com.spoonofcode.feature.profile.data.di.profileDataModule
import com.spoonofcode.feature.profile.domain.di.profileDomainModule
import com.spoonofcode.feature.profile.presentation.di.profilePresentationModule
import com.spoonofcode.feature.task.data.di.taskDataModule
import com.spoonofcode.feature.task.domain.di.taskDomainModule
import com.spoonofcode.feature.task.presentation.di.taskPresentationModule
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import repository.TaskRepository

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    singleOf(::TaskRepository)

    includes(
        //core
        coroutinesModule,
        firebaseDataModule,
        presentationModule,
        networkModule,
        recaptchaModule,
        sessionDataModule,
        sessionDomainModule,
        storageDataModule,

        //feature
        homeDataModule,
        homeDomainModule,
        homePresentationModule,

        profileDataModule,
        profileDomainModule,
        profilePresentationModule,

        notificationDataModule,
        notificationDomainModule,
        notificationPresentationModule,

        taskDataModule,
        taskDomainModule,
        taskPresentationModule,
    )

}