package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to load an object that is not a Protected Object into the TPM.
 *  The command allows loading of a public area or both a public and sensitive area.
 */
public class TPM2_LoadExternal_REQUEST extends TpmStructure
{
    /** The sensitive portion of the object (optional)  */
    public TPMT_SENSITIVE inPrivate;
    
    /** The public portion of the object  */
    public TPMT_PUBLIC inPublic;
    
    /** Hierarchy with which the object area is associated  */
    public TPM_HANDLE hierarchy;
    
    public TPM2_LoadExternal_REQUEST() { hierarchy = new TPM_HANDLE(); }
    
    /** @param _inPrivate The sensitive portion of the object (optional)
     *  @param _inPublic The public portion of the object
     *  @param _hierarchy Hierarchy with which the object area is associated
     */
    public TPM2_LoadExternal_REQUEST(TPMT_SENSITIVE _inPrivate, TPMT_PUBLIC _inPublic, TPM_HANDLE _hierarchy)
    {
        inPrivate = _inPrivate;
        inPublic = _inPublic;
        hierarchy = _hierarchy;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeShort(inPrivate != null ? inPrivate.toTpm().length : 0);
        if (inPrivate != null)
            inPrivate.toTpm(buf);
        buf.writeShort(inPublic != null ? inPublic.toTpm().length : 0);
        if (inPublic != null)
            inPublic.toTpm(buf);
        hierarchy.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _inPrivateSize = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _inPrivateSize));
        inPrivate = TPMT_SENSITIVE.fromTpm(buf);
        buf.structSize.pop();
        int _inPublicSize = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _inPublicSize));
        inPublic = TPMT_PUBLIC.fromTpm(buf);
        buf.structSize.pop();
        hierarchy = TPM_HANDLE.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_LoadExternal_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_LoadExternal_REQUEST ret = new TPM2_LoadExternal_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_LoadExternal_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_LoadExternal_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_LoadExternal_REQUEST ret = new TPM2_LoadExternal_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_LoadExternal_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMT_SENSITIVE", "inPrivate", inPrivate);
        _p.add(d, "TPMT_PUBLIC", "inPublic", inPublic);
        _p.add(d, "TPM_HANDLE", "hierarchy", hierarchy);
    }
}

//<<<
