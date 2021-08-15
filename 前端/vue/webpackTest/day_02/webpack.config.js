const path = require('path');
const htmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: './src/main.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ["style-loader", "css-loader",],
            },
            {
                test: /\.m?js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                  loader: 'babel-loader',
                  options: {
                    // presets: ['@babel/preset-env']
                    presets: ['es2015']
                  }
                }
            },
            {
                test:/\.vue$/,
                use:['vue-loader']
            }
        ],

    },

    resolve:{
        alias:{
            'vue$': 'vue/dist/vue.esm.js'
        }
    },

    plugins :[
        new htmlWebpackPlugin()
    ]

}