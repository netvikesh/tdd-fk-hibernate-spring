"use strict";
module.exports = function (grunt) {
    grunt.initConfig({
        uglify: {
            target: {
                options: {
                    compress: {
                        drop_console: true
                    },
                    mangle: {
                        reserved: ['jQuery', 'bootstrap', 'React']
                    },
                },
                files: [
                    {
                        expand: true,
                        cwd: './src/main/webapp/WEB-INF/app-dev/js',
                        src: ['**/*.js'],
                        dest: ['./src/main/webapp/WEB-INF/dist/js'],
                        ext: '.min.js'
                    }
                ]
            }
        },
        watch: {
            scripts: {
                files: './src/main/webapp/WEB-INF/app-dev/js/**.jsx',
                tasks: ['web_pack'],
                options: {
                    interrupt: true,
                    reloadPage: true
                },
            },
        },
        webpack: {
            dist: require("./webpack.config.js"),
        }
    });
    grunt.loadNpmTasks('grunt-webpack');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.registerTask('web_pack', ['webpack']);
    grunt.registerTask('default', ['webpack']);
};
