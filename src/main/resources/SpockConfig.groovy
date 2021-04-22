import java.text.SimpleDateFormat

spockReports {
    def date = new Date()
    def sdf = new SimpleDateFormat("ddMMMyy_HH-mm-ss")
    String folderName = sdf.format(date)
    System.setProperty('dateStamp', folderName)
    set 'com.athaydes.spockframework.report.outputDir': "target/Reports/${folderName}"
    set 'com.athaydes.spockframework.report.IReportCreator': 'com.athaydes.spockframework.report.template.TemplateReportCreator'
    set 'com.athaydes.spockframework.report.showCodeBlocks': true
    set 'com.athaydes.spockframework.report.projectName': 'Test-POC'
    set 'com.athaydes.spockframework.report.projectVersion': 'POC-1.0'
    set 'com.athaydes.spockframework.report.template.TemplateReportCreator.specTemplateFile': '/templates/spec-template.html'
    set 'com.athaydes.spockframework.report.template.TemplateReportCreator.reportFileExtension': 'html'
    set 'com.athaydes.spockframework.report.template.TemplateReportCreator.summaryTemplateFile': '/templates/summary-template.html'
    set 'com.athaydes.spockframework.report.template.TemplateReportCreator.summaryFileName': 'index.html'
    set 'com.athaydes.spockframework.report.projectVersion': '0.2.6'
}
report {
    issueNamePrefix 'XRAY ID : '
    issueUrlPrefix 'https://jira.co.uk/browse/'
}
