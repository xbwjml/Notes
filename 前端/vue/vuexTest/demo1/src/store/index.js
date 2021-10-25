import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count:0
    ,msg:'java No1'
  },
  mutations: {
    //不要在mutations中执行异步操作
    addd(state){
      state.count++;
    },

    addN(state, data){
      state.count += data;
    },

    sub(state){
      state.count--;
    },

    subN(state,data){
      state.count -= data;
    }
  },

  actions: {
    //可用于执行异步操作
    addAsyncc(context){
      setTimeout(() => {
        context.commit('addd');
      }, 1000);
    }
  },

  getters:{
    showNum(state){
      return '当前数量为: '+state.count;
    }
  },

  modules: {
  }
})
