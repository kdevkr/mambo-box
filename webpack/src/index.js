import Vue from 'vue'
import axios from 'axios'
// import VueAxios from 'vue-axios'
import lodash from 'lodash'
// import VueLodash from 'vue-lodash'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import '@/css/common.scss';

import App from "./page/index.vue"

Vue.config.productionTip = false
Vue.config.performance = true
Vue.prototype.production = process.env.NODE_ENV == 'production'

window.axios = axios
axios.defaults.withCredentials = true
// Vue.use(VueAxios, axios)

window.lodash = lodash
// Vue.use(VueLodash, lodash)

Vue.use(BootstrapVue)

new Vue({
  render: h => h(App)
}).$mount("#app");
