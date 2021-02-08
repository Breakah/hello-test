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
                git url: 'http://10.250.8.1:8929/root/hello-test.git', branch: 'remote'
            }            
        
        stage('Test-firefox'){
            steps{
                withGradle{
                    sh './gradlew test -Pserver=${SERVER} -Pbrowser=firefox -Pheadlees=${HEADLESS}'
                }
            }
            post{
               always{
                    junit 'build/test-results/test/TEST-*.xml'  
                    publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'build/reports/pmd', 
                       reportFiles: '*.html', 
                       reportName: 'HTML Report', 
                       reportTitles: 'HTML Report'
		    ])
		    recordIssues{
		       ennableForFailure: true, aggregatingResults: true,
		       tools: [pmdParser(), checkStyle(pattern: 'build/reports/pmd/*.xml', reportEncoding: 'UTF-8')]
		    }
                }
            }          
        }

        stage('Build') {
            steps {                
                withGradle {
                    sh './gradlew assemble'
                }
            }
            pos t{
                succes s{
                    archiveArtifacts 'build/libs/*.jar'
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

}
