
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RequestManager from "./components/RequestManager"

import TradeManager from "./components/TradeManager"
import BidManager from "./components/BidManager"
import AskManager from "./components/AskManager"


import Prices from "./components/Prices"

import Asset from "./components/Asset"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/requests',
                name: 'RequestManager',
                component: RequestManager
            },

            {
                path: '/trades',
                name: 'TradeManager',
                component: TradeManager
            },
            {
                path: '/bids',
                name: 'BidManager',
                component: BidManager
            },
            {
                path: '/asks',
                name: 'AskManager',
                component: AskManager
            },


            {
                path: '/prices',
                name: 'Prices',
                component: Prices
            },

            {
                path: '/assets',
                name: 'Asset',
                component: Asset
            },



    ]
})
