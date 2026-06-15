import features.task.TaskOverviewViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

val viewModelModule = module {
    viewModelOf(::TaskOverviewViewModel)
}