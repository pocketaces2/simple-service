pipeline {
    agent any
    //Configured in jenkins 'global tool configuration'
    tools {
      maven 'MAVEN_HOME'
      jdk 'JAVA_HOME'
    }
    stages {
        
        //Checkout the code
        stage("Preparation") {
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pocketaces2/simple-service']]])
            }
        }
        
        //Build the simple service using maven
        stage('Build') {
            steps {
                sh "mvn --pl simple-service clean package"

            }
        }
        
        //Run the jar file (service) and keep it running in the background
        stage('Run Service') {
            steps {
                sh "java -jar simple-service/target/*SNAPSHOT.jar &"
            }
            
        }
        
        //Run the cucumber tests using maven
        stage('Automation tests') {
            steps {
                    sh 'mvn --pl simple-service-automation test'
            }
            // Publish a cucumber report after running the tests either via the cucumber plugin or the html publisher plugin
            post {
              always {
                  publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'simple-service-automation/target/', reportFiles: 'cucumber-reports.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
                   cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'NATURAL', undefinedStepsNumber: -1
                }
            }

            
        }
    }
}
