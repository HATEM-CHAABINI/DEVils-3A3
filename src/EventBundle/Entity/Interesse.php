<?php

namespace EventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Interesse
 *
 * @ORM\Table(name="interesse", indexes={@ORM\Index(name="fk_inetre", columns={"id"}), @ORM\Index(name="fk_inetres", columns={"idEvent"})})
 * @ORM\Entity
 */
class Interesse
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idIntere", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idintere;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=255, nullable=false)
     */
    private $etat;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id", referencedColumnName="id")
     * })
     */
    private $id;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idEvent", referencedColumnName="idEvent")
     * })
     */
    private $idevent;



    /**
     * Get idintere
     *
     * @return integer
     */
    public function getIdintere()
    {
        return $this->idintere;
    }

    /**
     * Set etat
     *
     * @param string $etat
     *
     * @return Interesse
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return string
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Set id
     *
     * @param \EventBundle\Entity\FosUser $id
     *
     * @return Interesse
     */
    public function setId(\EventBundle\Entity\FosUser $id = null)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * Get id
     *
     * @return \EventBundle\Entity\FosUser
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set idevent
     *
     * @param \EventBundle\Entity\Evenement $idevent
     *
     * @return Interesse
     */
    public function setIdevent(\EventBundle\Entity\Evenement $idevent = null)
    {
        $this->idevent = $idevent;

        return $this;
    }

    /**
     * Get idevent
     *
     * @return \EventBundle\Entity\Evenement
     */
    public function getIdevent()
    {
        return $this->idevent;
    }
}
