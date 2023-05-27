#Region "Help:  Introduction to the script task"
'The Script Task allows you to perform virtually any operation that can be accomplished in
'a .Net application within the context of an Integration Services control flow. 

'Expand the other regions which have "Help" prefixes for examples of specific ways to use
'Integration Services features within this script task.
#End Region


#Region "Imports"
Imports System
Imports System.Data
Imports System.Math
Imports Microsoft.SqlServer.Dts.Runtime
#End Region


<Microsoft.SqlServer.Dts.Tasks.ScriptTask.SSISScriptTaskEntryPointAttribute()> _
<System.CLSCompliantAttribute(False)> _
Partial Public Class ScriptMain
    Inherits Microsoft.SqlServer.Dts.Tasks.ScriptTask.VSTARTScriptObjectModelBase

#Region "Help:  Using Integration Services variables and parameters in a script"

#End Region

#Region "Help:  Firing Integration Services events from a script"
 
#End Region

#Region "Help:  Using Integration Services connection managers in a script"

#End Region

    Public Sub emptyChecker()
        If String.IsNullOrEmpty(Dts.Variables("Matakuliah").Value.ToString()) And String.IsNullOrEmpty(Dts.Variables("Jam").Value.ToString()) And String.IsNullOrEmpty(Dts.Variables("ruang").Value.ToString()) Then
            MsgBox(Dts.Variables("Nama").Value.ToString() & " pada hari " & Dts.Variables("hari").Value.ToString() & " tidak memiliki jadwal")
        Else
            MsgBox("dosen " & Dts.Variables("Nama").Value.ToString() & " memiliki jadwal ")
        End If
    End Sub
    Public Sub Main()

        emptyChecker()
        Dts.TaskResult = ScriptResults.Success
    End Sub

#Region "ScriptResults declaration"

    Enum ScriptResults
        Success = Microsoft.SqlServer.Dts.Runtime.DTSExecResult.Success
        Failure = Microsoft.SqlServer.Dts.Runtime.DTSExecResult.Failure
    End Enum

#End Region

End Class