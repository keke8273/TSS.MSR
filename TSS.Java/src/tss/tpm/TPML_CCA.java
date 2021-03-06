package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This list is only used in TPM2_GetCapability(capability = TPM_CAP_COMMANDS).  */
public class TPML_CCA extends TpmStructure implements TPMU_CAPABILITIES
{
    /** A list of command codes attributes  */
    public TPMA_CC[] commandAttributes;
    
    public TPML_CCA() {}
    
    /** @param _commandAttributes A list of command codes attributes  */
    public TPML_CCA(TPMA_CC[] _commandAttributes) { commandAttributes = _commandAttributes; }
    
    /** TpmUnion method  */
    public TPM_CAP GetUnionSelector() { return TPM_CAP.COMMANDS; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeObjArr(commandAttributes);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _count = buf.readInt();
        commandAttributes = new TPMA_CC[_count];
        for (int j=0; j<_count; j++)
            (commandAttributes[j] = new TPMA_CC(0)).initFromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPML_CCA fromBytes (byte[] byteBuf) 
    {
        TPML_CCA ret = new TPML_CCA();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPML_CCA fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPML_CCA fromTpm (InByteBuf buf) 
    {
        TPML_CCA ret = new TPML_CCA();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPML_CCA");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMA_CC", "commandAttributes", commandAttributes);
    }
}

//<<<
