var webpack = require('webpack');
var path = require('path');
var config = {
    entry: './src/main/webapp/WEB-INF/app-dev/js/app.jsx',
    output: {
        filename: './src/main/webapp/WEB-INF/app-dev/js/bundle.js'
    },
    plugins: [
        new webpack.LoaderOptionsPlugin({
            debug: true
        })],
    devtool: 'inline-source-map',
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                loader: 'babel-loader',
                exclude: /node-modules/,
                query: {
                    presets: ['es2015', 'react','stage-2']
                }
            }
        ]
    }
};

module.exports = config;