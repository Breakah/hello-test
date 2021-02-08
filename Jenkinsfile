#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        jdk 'openJDK-15.0.02'
    }
    options {
        ansiColor('xterm')
    }
    environment {
        SERVER = 'https://10.250.8.1:4444'
        HEADLESS = 'false'
    }
    stages {
        stage('Setup') {
            steps {
                git url: 'http://10.250.8.1:8929/root/hello-test.git', branch: 'spotbugs'
                sh './gradlew clean'
            }            
        }
        stage('Test-firefox-checkstyle'){
            steps{
                withGradle{
                     sh './gradlew clean check -Pserver=${SERVER} -Pbrowser=firefox -Pheadlees=${HEADLESS}'
                }
            }
            post{
               always{
                    //junit 'build/test-results/test/TEST-*.xml'  
                    
            	recordIssues enabledForFailure: true, tool: spotbugs(pattern: 'build/reports/spotbugs/*.xml')                
            	}          
            }
        }
       /* stage('Build') {
            steps {                
                withGradle {
                    sh './gradlew assemble'
                }
            }
            post{
                success{
                    archiveArtifacts 'build/libs/*.jar'
                    echo ".Jar Guardados en build/libs"
                }
            }            
        }
        stage('Deploy') {
            steps {
                echo "Deploy...."
            }
        }*/
    }
}
