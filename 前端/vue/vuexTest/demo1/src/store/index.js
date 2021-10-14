import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count:0
    ,msg:'java No1'
  },
  mutations: {
    addd(state){
      state.count++;
    }
  },
  actions: {
  },
  modules: {
  }
})
