job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/isaigt/nodejsapptest.git', 'master') { node ->
            node / gitConfigName('Isai Gonzalez')
            node / gitConfigEmail('isaigonzalez101@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('isaigt/nodejsapptest')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
 //    publishers {
	// slackNotifier {
 //            notifyAborted(true)
 //            notifyEveryFailure(true)
 //            notifyNotBuilt(false)
 //            notifyUnstable(false)
 //            notifyBackToNormal(true)
 //            notifySuccess(true)
 //            notifyRepeatedFailure(false)
 //            startNotification(false)
 //            includeTestSummary(false)
 //            includeCustomMessage(false)
 //            customMessage(null)
 //            sendAs(null)
 //            commitInfoChoice('NONE')
 //            teamDomain(null)
 //            authToken(null)
 //        }
 //    }
}
