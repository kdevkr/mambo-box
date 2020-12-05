const path = require('path');
const webpack = require('webpack');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const TerserPlugin = require('terser-webpack-plugin');
const { WebpackManifestPlugin } = require('webpack-manifest-plugin')
const { CleanWebpackPlugin } = require('clean-webpack-plugin')
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const ESLintWebpackPlugin = require('eslint-webpack-plugin')

module.exports = {
  mode: 'development',

  stats: {
      children: false,
      colors: true,
      modules: false,
      reasons: true
  },

  entry: {
    index: path.resolve(__dirname, 'src/index.js'),
    // main: path.resolve(__dirname, 'src/main.js')
  },

  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'js/[name].bundle.js',
    publicPath: '/dist/'
  },

  resolve: {
    extensions: ['.js', '.vue', '.css', '.scss'],
    alias: {
      vue$: 'vue/dist/vue.esm.js',
      '@': path.resolve(__dirname, 'src'),
      '~': path.resolve(__dirname, 'src'),
    },
    modules: [
        path.resolve(__dirname, 'src/css'),
        "node_modules",
    ]
  },

  plugins: [
    new webpack.ProgressPlugin(),
    new webpack.ProvidePlugin({
      Vue: 'vue/dist/vue.esm.js'
    }),
    new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/),
    new ESLintWebpackPlugin(),
    new VueLoaderPlugin(),
    new MiniCssExtractPlugin({
      filename:'css/[name].bundle.css',
      chunkFilename: "css/[name].bundle.[chunkhash].css"
    }),
    new CleanWebpackPlugin(),
    new WebpackManifestPlugin()
  ],

  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        include: [path.resolve(__dirname, 'src')],
        exclude: /(node_modules)/,
        loader: 'babel-loader'
      },
      {
        test: /.s(a|c)ss$/,
        exclude: /(node_modules)/,
        use: [
          { loader: MiniCssExtractPlugin.loader },
          { loader: "css-loader",
            options: {
              importLoaders: 1,
              sourceMap: true
            }
          },
          { loader: "postcss-loader" },
          { loader: "resolve-url-loader" },
          { loader: "sass-loader" }
        ]
      },
      {
        test: /\.css$/,
        include: /(node_modules)/,
        use: [
          { loader: MiniCssExtractPlugin.loader },
          { loader: "css-loader" },
          { loader: "postcss-loader" }
        ]
      },
      {
        test: /\.less$/,
        use: [
          { loader: MiniCssExtractPlugin.loader },
          { loader: "css-loader" },
          { loader: "postcss-loader" },
          { loader: "less-loader" }
        ]
      },
      {
        test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
        loader: 'url-loader',
        options: {
          limit: 1024,
          name: 'images/[name].[ext]?[contenthash]'
        }
      },
      {
        test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
        loader: 'url-loader',
        options: {
          limit: 1024,
          name: 'fonts/[name].[ext]?[contenthash]'
        }
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          name: '[name].[ext]?[chunkhash]',
          postLoaders: {
              html: 'babel-loader'
          },
          extractCSS: true,
          loaders: {
            scss: [
              'vue-style-loader',
              'css-loader',
              'sass-loader',
              {
                loader: 'sass-resources-loader',
                options: {
                  resources: [
                    // Custom override variables
                    path.resolve(__dirname, 'src/css/variables.scss'),
                    path.resolve(__dirname, 'src/css/mixins.scss'),
                  ]
                }
              }
            ]
          }
        },
      }
    ]
  },

  optimization: {
    minimizer: [new TerserPlugin()],

    splitChunks: {
      cacheGroups: {
        vendors: {
          priority: -10,
          test: /[\\/]node_modules[\\/]/
        }
      },

      chunks: 'async',
      minChunks: 2,
      minSize: 30000,
      name: '_vendor'
    }
  }
}
