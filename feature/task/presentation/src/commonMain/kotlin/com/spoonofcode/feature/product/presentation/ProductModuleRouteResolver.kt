package com.spoonofcode.feature.task.presentation

import cafe.adriel.voyager.core.screen.Screen
import com.spoonofcode.core.presentation.navigation.route.ModuleRouteResolver
import com.spoonofcode.feature.appnavigation.ModuleRoute
import com.spoonofcode.feature.appnavigation.ProductModuleRoute
import com.spoonofcode.feature.task.presentation.details.ProductDetailsScreen
import com.spoonofcode.feature.task.presentation.edit.ProductEditScreen
import com.spoonofcode.feature.task.presentation.overview.ProductOverviewScreen
import com.spoonofcode.feature.task.presentation.series.overview.ProductSeriesOverviewScreen

class ProductModuleRouteResolver : ModuleRouteResolver<ProductModuleRoute> {
    override fun resolve(moduleRoute: ModuleRoute): Screen? =
        (moduleRoute as? ProductModuleRoute)?.let {
            when (it) {
                is ProductModuleRoute.ProductDetails -> ProductDetailsScreen(
                    productId = it.productId,
                )

                is ProductModuleRoute.ProductEdit -> ProductEditScreen(productId = it.productId)
                ProductModuleRoute.ProductOverview -> ProductOverviewScreen()
                ProductModuleRoute.ProductSeriesOverview -> ProductSeriesOverviewScreen()
            }
        }
}