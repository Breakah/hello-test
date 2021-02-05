#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        jdk 'openJDK-15.0.02'
    }
    options {
        ansiColor('xterm')
    }
    stages {
        stage('Setup'){
            steps{
                git url:'http://10.250.8.1:8929/root/hello-test.git',branch:'master' 
            }            
        }
        stage('Test'){
            steps{
                withGradle{
                    sh './gradlew test'
                }
            }
            post{
                always{
                    junit 'build/test-results/test/TEST-*.xml'  
                    publishHTML([
                        allowMissing: false, 
                        alwaysLinkToLastBuild: false, 
                        keepAll: false, 
                        reportDir: 'build/reports/tests/test', 
                        reportFiles: 'index.html', 
                        reportName: 'HTML Report', 
                        reportTitles: 'HTML Report'])
                }
            }          
        }

        stage('Build') {
            steps {                
                withGradle {
                    sh './gradlew assemble'
                }
            }
            post{
                success{
            //        archiveArtifacts 'build/libs/*.jar'
                    echo ".Jar Guardados en build/libs"
                }
            }            
        }
        stage('Deploy') {
            steps {
                echo "Deploy...."
            }
        }
    }
}


